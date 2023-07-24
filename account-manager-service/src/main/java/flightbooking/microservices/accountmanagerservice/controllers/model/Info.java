
package flightbooking.microservices.accountmanagerservice.controllers.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Info implements Serializable
{

    final static long serialVersionUID = 4221813170006486835L;
    protected String apiName;
    protected String version;

    /**
     * Creates a new Info.
     * 
     */
    public Info() {
        super();
    }

    /**
     * Creates a new Info.
     * 
     */
    public Info(String apiName, String version) {
        super();
        this.apiName = apiName;
        this.version = version;
    }

    /**
     * Returns the apiName.
     * 
     * @return
     *     apiName
     */
    @NotNull
    public String getApiName() {
        return apiName;
    }

    /**
     * Set the apiName.
     * 
     * @param apiName
     *     the new apiName
     */
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    /**
     * Returns the version.
     * 
     * @return
     *     version
     */
    @NotNull
    public String getVersion() {
        return version;
    }

    /**
     * Set the version.
     * 
     * @param version
     *     the new version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(apiName).append(version).toHashCode();
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
        Info otherObject = ((Info) other);
        return new EqualsBuilder().append(apiName, otherObject.apiName).append(version, otherObject.version).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("apiName", apiName).append("version", version).toString();
    }

}
