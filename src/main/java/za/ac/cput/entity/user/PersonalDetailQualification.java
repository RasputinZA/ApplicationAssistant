package za.ac.cput.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(PersonalDetailQualificationId.class)
public class PersonalDetailQualification   {

    @Id
    private String qualificationId, personalId;


    protected PersonalDetailQualification() {}

    public PersonalDetailQualification(Builder builder) {
        this.qualificationId = builder.qualificationId;
        this.personalId = builder.personalId;
    }


    public String getQualificationId() {
        return qualificationId;
    }

    public String getPersonalId() {
        return personalId;
    }

    @Override
    public String toString() {
        return "PersonalDetailQualification{" +
                "QualificationId='" + qualificationId + '\'' +
                ", PersonalID='" + personalId + '\'' +
                '}';
    }


    public static class Builder{

        private String qualificationId, personalId;

        public Builder setQualificationId(String qualificationId) {
            this.qualificationId = qualificationId;
            return this;
        }

        public Builder setPersonalId(String personalId) {
            this.personalId = personalId;
            return this;
        }



        public Builder copy(PersonalDetailQualification personalDetailQualification) {

            this.qualificationId = personalDetailQualification.qualificationId;
            this.personalId = personalDetailQualification.personalId;
            return this;

        }

        public PersonalDetailQualification build(){
            return new PersonalDetailQualification(this);
        }

    }

    }


