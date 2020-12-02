package za.ac.cput.entity.tertiaryInstitution;

import java.io.Serializable;
import java.util.Objects;

public class InstitutionFacultyId implements Serializable {

    private String  institutionId, facultyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionFacultyId that = (InstitutionFacultyId) o;
        return institutionId.equals(that.institutionId) &&
                facultyId.equals(that.facultyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(institutionId, facultyId);
    }
}
