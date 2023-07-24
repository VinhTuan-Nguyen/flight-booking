
package flightbooking.microservices.accountmanagerservice.controllers.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AccountInfo implements Serializable
{

    final static long serialVersionUID = 4213550749628098898L;
    @JsonProperty("user_id")
    protected String userId;
    protected String password;

    /**
     * Creates a new AccountInfo.
     * 
     */
    public AccountInfo() {
        super();
    }

    /**
     * Creates a new AccountInfo.
     * 
     */
    public AccountInfo(String userId, String password) {
        super();
        this.userId = userId;
        this.password = password;
    }

    /**
     * Returns the userId.
     * 
     * @return
     *     userId
     */
    @NotNull
    @Size(max = 20)
    public String getUserId() {
        return userId;
    }

    /**
     * Set the userId.
     * 
     * @param userId
     *     the new userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns the password.
     * 
     * @return
     *     password
     */
    @NotNull
    @Size(max = 45)
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     * 
     * @param password
     *     the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(userId).append(password).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (this.getClass()!= other.getClass()) {
            return false;
        }
        AccountInfo otherObject = ((AccountInfo) other);
        return new EqualsBuilder().append(userId, otherObject.userId).append(password, otherObject.password).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("userId", userId).append("password", password).toString();
    }

}
