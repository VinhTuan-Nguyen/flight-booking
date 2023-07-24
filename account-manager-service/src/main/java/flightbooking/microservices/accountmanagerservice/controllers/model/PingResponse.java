
package flightbooking.microservices.accountmanagerservice.controllers.model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PingResponse implements Serializable
{

    final static long serialVersionUID = 4188763492787902386L;
    protected Status status;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    protected Date timeStamp;
    protected String transaction;
    protected Info info;

    /**
     * Creates a new PingResponse.
     *
     */
    public PingResponse() {
        super();
    }

    /**
     * Creates a new PingResponse.
     *
     */
    public PingResponse(Status status, Date timeStamp, String transaction, Info info) {
        super();
        this.status = status;
        this.timeStamp = timeStamp;
        this.transaction = transaction;
        this.info = info;
    }

    /**
     * Returns the status.
     *
     * @return
     *     status
     */
    @NotNull
    @Valid
    public Status getStatus() {
        return status;
    }

    /**
     * Set the status.
     *
     * @param status
     *     the new status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Returns the timeStamp.
     *
     * @return
     *     timeStamp
     */
    @NotNull
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * Set the timeStamp.
     *
     * @param timeStamp
     *     the new timeStamp
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Returns the transaction.
     *
     * @return
     *     transaction
     */
    @NotNull
    public String getTransaction() {
        return transaction;
    }

    /**
     * Set the transaction.
     *
     * @param transaction
     *     the new transaction
     */
    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    /**
     * Returns the info.
     *
     * @return
     *     info
     */
    @NotNull
    @Valid
    public Info getInfo() {
        return info;
    }

    /**
     * Set the info.
     *
     * @param info
     *     the new info
     */
    public void setInfo(Info info) {
        this.info = info;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(status).append(timeStamp).append(transaction).append(info).toHashCode();
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
        PingResponse otherObject = ((PingResponse) other);
        return new EqualsBuilder().append(status, otherObject.status).append(timeStamp, otherObject.timeStamp).append(transaction, otherObject.transaction).append(info, otherObject.info).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("timeStamp", timeStamp).append("transaction", transaction).append("info", info).toString();
    }

}
