package za.ac.cput.entity.user;

import java.io.Serializable;
import java.util.Objects;

public class PersonalDetailQualificationId implements Serializable {

    private String qualificationId, personalId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalDetailQualificationId that = (PersonalDetailQualificationId) o;
        return qualificationId.equals(that.qualificationId) &&
                personalId.equals(that.personalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualificationId, personalId);
    }
}
