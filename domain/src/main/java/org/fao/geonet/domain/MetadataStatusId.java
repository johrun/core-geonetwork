package org.fao.geonet.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The id object of {@link MetadataStatus}.
 * 
 * @author Jesse
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class MetadataStatusId implements Serializable {
    private static final long serialVersionUID = -4395314364468537427L;
    private ISODate _changedate;
    private int _metadataId;
    private int _statusId;
    private int _userId;

    /**
     * Get the date of the status change in string form.
     * 
     * @return the date of the status change in string form.
     */
    @AttributeOverride(name="dateAndTime", column = @Column(name = "changedate", nullable = false, length = 30) )
    public ISODate getChangeDate() {
        return _changedate;
    }

    /**
     * Set the date of the status change in string form. 
     * 
     * @param changedate the date of the status change in string form. 
     */
    public void setChangeDate(ISODate changedate) {
        this._changedate = changedate;
    }

    /**
     * Get the id of the metadata the status is related to.
     * 
     * @return the id of the metadata the status is related to.
     */
    public int getMetadataId() {
        return _metadataId;
    }

    /**
     * Set the id of the metadata the status is related to.
     * 
     * @param metadataId the id of the metadata the status is related to.
     */
    public void setMetadataId(int metadataId) {
        this._metadataId = metadataId;
    }

    /**
     * Get the id of the new status.
     * 
     * @return the id of the new status.
     */
    public int getStatusId() {
        return _statusId;
    }

    /**
     * Set the id of the new status.
     * 
     * @param statusId the id of the new status.
     */
    public void setStatusId(int statusId) {
        this._statusId = statusId;
    }

    /**
     * Get the user who is responsible for changing the status.
     * 
     * @return the user who is responsible for changing the status.
     */
    public int getUserId() {
        return _userId;
    }

    /**
     * Set the user who is responsible for changing the status.
     * 
     * @param userId the user who is responsible for changing the status.
     */
    public void setUserId(int userId) {
        this._userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_changedate == null) ? 0 : _changedate.hashCode());
        result = prime * result + _metadataId;
        result = prime * result + _statusId;
        result = prime * result + _userId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MetadataStatusId other = (MetadataStatusId) obj;
        if (_changedate == null) {
            if (other._changedate != null)
                return false;
        } else if (!_changedate.equals(other._changedate))
            return false;
        if (_metadataId != other._metadataId)
            return false;
        if (_statusId != other._statusId)
            return false;
        if (_userId != other._userId)
            return false;
        return true;
    }
}