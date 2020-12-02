package za.ac.cput.entity.tertiaryInstitution;

import za.ac.cput.entity.user.PersonalDetailQualification;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(InstitutionFacultyId.class)
public class InstitutionFaculty {

    @Id
    private String institutionId, facultyId;

    protected InstitutionFaculty(){}

    public String getInstitutionId() {
        return institutionId;
    }

    public String getFacultyId() {
        return facultyId;
    }



    public InstitutionFaculty(Builder builder){
        this.institutionId = builder.institutionId;
        this.facultyId = builder.facultyId;



    }

    @Override
    public String toString() {
        return "InstitutionFaculty{" +
                "InstitutionId='" + institutionId + '\'' +
                ", FacultyId='" + facultyId + '\'' +
                '}';
    }

    public static class Builder{
        private String institutionId, facultyId;

        public Builder setInstitutionId(String institutionId) {
            this.institutionId = institutionId;
            return this;
        }

        public Builder setFacultyId(String facultyId) {
            this.facultyId = facultyId;
            return this;
        }

        public InstitutionFaculty.Builder copy(InstitutionFaculty institutionFaculty) {

            this.institutionId = institutionFaculty.institutionId;
            this.facultyId = institutionFaculty.institutionId;
            return this;

        }

        public InstitutionFaculty build(){
            return new InstitutionFaculty(this);
        }
    }


}
