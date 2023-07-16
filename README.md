# Thiết kế chi tiết hệ thống booking bằng micro service hỗ trợ chịu tải lớn bằng Java và Spring boot, MySQL
##### Bài toán: Xây dựng một hệ thống quản lý booking vé máy bay tổng hợp cho các đại lý bán vé máy bay và người dùng đầu cuối.
[Link Details:](https://viblo.asia/p/thiet-ke-chi-tiet-he-thong-booking-bang-micro-service-ho-tro-chiu-tai-lon-bang-java-va-spring-boot-mysql-AZoJjXeyVY7#_service-discovery-eureka-10)

## Mô Tả Hệ Thống
 - Hệ thống sẽ kết nối trực tiếp với các api của các bên cung cấp dịch vụ đặt vé như vietnam airline, Vietjet air ...
- Hệ thống kết nối trực tiếp với các cổng thanh toán trong nước
- Hệ thống kết nối tới các phần mềm quản lý khách hàng và tra cứu thông tin
- Hệ thống cần hỗ trợ lượng lớn người dùng vào một thời điểm và có thể scale khả năng chịu tải cho api.
- Hệ thống cần handle được tất cả các yêu cầu booking và thanh toán để có thể xử lý tuần tự, Các giao dịch thanh toán  trựctuyến cần được ưu tiên xử lý khi có yêu cầu xác thực bằng OTP.
- Hệ thống cần khoá lại các booking đang được đợi xử lý và có cơ chế mở khoá nếu book không thành công.

## Các công nghệ sẽ sử dụng phát triển hệ thống
- **API gateway**: Sử dụng NginX để handle và phân phối các request.
- **Message Queue**: Sử dụng message queue để handle lượng lớn các quest booking tại một thời điểm, sử dụng multiple consumer để xử lý các yêu cầu booking.
- **Database**: JPA, MySQL, h2 database, MongoDB, Redis.: Sử dụng h2 database để lưu data in memory cho một số data cần sử dụng thường xuyên.
- Các micro service giao tiếp với nhau qua **Restful API**,
- **Service discovery**: Eureka
- **Banking service**, **SMS service**
- **Worker**: Các job đồng bộ thông tin với các đối tác, xử lý các tính toán tạo report.
- **Caching**: lưu các thông tin thường xuyên truy cập như: danh sách chuyến bay, số lượng hành khách, lịch sử xem của khách hàng.

## Thiết kế các micro service:
- **Service Account manager**: cho phép người dùng đăng ký, đăng nhập, quản lý thông tin tài khoản.
- **Service Payment gateway**: Cho phép người dùng thanh toán, hoàn tiền, tra soát giao dịch. kết nối với các trung gian thanh toán.
- **Service Booking**: Cho phép người dùng đặt hoặc huỷ chuyến, tìm kiếm các chuyến bay.
- **Service Booking history**: Cho phép người dùng xem lịch sử và thông tin vé.
- **Service Notification**: gửi các thông tin vé, thông báo thay đổi cho người dùng, email xác thực. email quảng cáo.
- **Service Ads**: Quản lý các chương trình khuyến mãi.

## Thiết kế cơ sở dữ liệu
###### Hệ thống sử dụng cơ sở dữ liệu chính là MySQL, Các service sẽ sử dụng các database của riêng mình và được triển khai trên các container khác nhau. Đối với các service cần truy vấn các thông tin tĩnh liên tục chúng ta sử dụng thêm in-memory database Redis

### Các database sử dụng MySQL
- User Database
- Transaction database
- Promotion database

### Các database sử dụng MongoDB
- Booking database
- Notification database
- Ads Database

### Danh sách thiết kế các Database

#### *User Database*

|**Tên bảng**|**Mô tả**|
|------------|---------|
|Users|Lưu trữ thông tin user, password|
|Profiles|Lưu trữ thông tin cá nhân của user như: Tên, ngày sinh, số cmt , số cccd, Địa chỉ, Avatar...|
|UserRoles|Bảng liên kết User và Roles|
|Roles|Lưu trữ thông tin về các role của user|
|Permissions|Lưu trữ các quyền truy cập khác nhau trong hệ thống, ví dụ như quyền đọc, quyền ghi, quyền xóa.|
|RolePermissions|Liên kết giữa bảng Roles và bảng Permissions để xác định quyền truy cập của vai trò trong hệ thống.|
|LoginAttempts|Lưu trữ thông tin về các lần đăng nhập không thành công của người dùng, bao gồm IP, thời gian và số lần thử đăng nhập.|
|PasswordResets|Lưu trữ thông tin về các yêu cầu đặt lại mật khẩu của người dùng, bao gồm token, thời gian và trạng thái yêu cầu.|

#### *Transaction Database*

|**Tên bảng**|**Mô tả**|
|------------|---------|
|Transactions|Lưu trữ thông tin về các giao dịch được thực hiện, bao gồm các trường như mã giao dịch, ngày giao dịch, loại giao dịch, giá trị giao dịch và các thông tin khác liên quan.|
|Categories|Lưu trữ các danh mục cho các giao dịch, bao gồm các trường như mã danh mục, tên danh mục và các thông tin liên quan.|
|Subcategories|Lưu trữ các danh mục con cho các danh mục, bao gồm các trường như mã danh mục con, tên danh mục con, mã danh mục cha và các thông tin liên quan|
|PaymentMethods|Lưu trữ các phương thức thanh toán được sử dụng trong các giao dịch, bao gồm các trường như mã phương thức, tên phương thức và các thông tin liên quan.|
|TransactionsCategories|Liên kết giữa bảng Transactions và bảng Categories để xác định danh mục của mỗi giao dịch.
|TransactionsSubcategories|Liên kết giữa bảng Transactions và bảng Subcategories để xác định danh mục con của mỗi giao dịch.|
|TransactionsPaymentMethods|Liên kết giữa bảng Transactions và bảng PaymentMethods để xác định phương thức thanh toán của mỗi giao dịch.|

#### *Promotion Database*

|**Tên bảng**|**Mô tả**|
|------------|---------|
|Promotions|Lưu trữ thông tin về các chương trình khuyến mãi, bao gồm các trường như tên khuyến mãi, mô tả, ngày bắt đầu, ngày kết thúc và các thông tin liên quan.|
|PromotedRooms|Liên kết giữa bảng Promotions và bảng Rooms để xác định loại phòng được áp dụng khuyến mãi|
|PromotedFlights|Liên kết giữa bảng Promotions và bảng Rooms để xác định loại phòng được áp dụng khuyến mãi|
|DiscountTypes|Lưu trữ thông tin về các loại giảm giá, bao gồm các trường như tên, mô tả và các thông tin liên quan.|
|PromotionsDiscountTypes|Liên kết giữa bảng Promotions và bảng DiscountTypes để xác định loại giảm giá được áp dụng cho từng chương trình khuyến mãi.|
|PromotionCodes|Lưu trữ thông tin về các mã khuyến mãi, bao gồm các trường như mã code, mô tả và các thông tin liên quan.|
|PromotionsPromotionCodes|Liên kết giữa bảng Promotions và bảng PromotionCodes để xác định mã khuyến mãi được áp dụng cho từng chương trình khuyến mãi.|

#### *Booking Database*

|**Tên bảng**|**Mô tả**|
|------------|---------|
|Bookings|Lưu trữ thông tin về các đặt phòng của khách hàng, bao gồm các trường như mã đặt phòng, ngày đặt phòng, ngày nhận phòng, ngày trả phòng, số lượng khách, số lượng phòng và các thông tin liên quan.|
|Rooms|Lưu trữ thông tin về các phòng khách sạn, bao gồm các trường như mã phòng, loại phòng, giá phòng, số lượng giường, số lượng khách tối đa, tình trạng phòng và các thông tin liên quan.|
|Flights|Lưu trữ thông tin về các chuyến bay, bao gồm các trường như mã chuyến bay, ngày khởi hành, giờ khởi hành, điểm khởi hành, điểm đến, số chỗ trống, giá vé và các thông tin liên quan.|
|Customers|Lưu trữ thông tin về các khách hàng, bao gồm các trường như tên khách hàng, địa chỉ email, số điện thoại, địa chỉ và các thông tin liên quan.|
|BookingRooms|Liên kết giữa bảng Bookings và bảng Rooms để xác định phòng khách hàng đã đặt trong mỗi đặt phòng.|
|BookingFlights|Liên kết giữa bảng Bookings và bảng Flights để xác định chuyến bay liên quan đến mỗi đặt chỗ.|
|BookingCustomers|Liên kết giữa bảng Bookings và bảng Customers để xác định khách hàng liên quan đến mỗi đặt phòng.|
|BookingPayments|Liên kết giữa bảng Bookings và bảng Payments để xác định thanh toán liên quan đến mỗi đặt phòng.|
|Venders|Thông tin các nhà cung cấp dịch vụ
|Currency|Lưu thông tin currency

#### *Notification Database*

|**Tên bảng**|**Mô tả**|
|------------|---------|
|Messages|Lưu trữ thông tin về các tin nhắn, bao gồm các trường như tiêu đề, nội dung, ngày gửi, người gửi, người nhận và các thông tin liên quan.|
|MessageStatus|Lưu trữ trạng thái của các tin nhắn, bao gồm các trường như trạng thái đã gửi, đang chờ, đã nhận và các thông tin liên quan.|
|Templates|Lưu trữ các mẫu thông báo để sử dụng lại, bao gồm các trường như tiêu đề, nội dung, và các thông tin liên quan.|
|MessageRecipients|Liên kết giữa bảng Messages và bảng Users để xác định người nhận của mỗi tin nhắn.|
|MessageTemplates|Liên kết giữa bảng Messages và bảng Templates để xác định mẫu thông báo được sử dụng cho mỗi tin nhắn.|

#### *Ads Database*

|**Tên bảng**|**Mô tả**|
|------------|---------|
|Quảng cáo|Bảng này chứa thông tin về các chiến dịch quảng cáo, bao gồm tên chiến dịch, ngày bắt đầu và kết thúc, mục tiêu, ngân sách, đối tượng khách hàng, v.v.|
|Quảng cáo Hiển thị|Bảng này chứa thông tin về các quảng cáo hiển thị, bao gồm tiêu đề, hình ảnh, văn bản quảng cáo, liên kết đến trang web, địa chỉ URL, v.v.|
|Khách hàng mục tiêu|Bảng này chứa thông tin về đối tượng khách hàng mục tiêu của chiến dịch quảng cáo, bao gồm độ tuổi, giới tính, vị trí địa lý, sở thích, hành vi, v.v.|
|Phương tiện truyền thông|Bảng này chứa thông tin về các phương tiện truyền thông sử dụng trong chiến dịch quảng cáo, bao gồm các kênh quảng cáo trực tuyến, truyền hình, tạp chí, v.v.|
|Kết quả quảng cáo|Bảng này chứa thông tin về kết quả của chiến dịch quảng cáo, bao gồm số lượt hiển thị, số lượt nhấp chuột, tỷ lệ chuyển đổi, chi phí cho mỗi lượt nhấp chuột, v.v.|
