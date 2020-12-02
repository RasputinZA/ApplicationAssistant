package za.ac.cput.service.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.service.IService;

import java.util.Set;

public interface InstitutionService extends IService<Institution, String> {

    Set<Institution> getAll();

    Set<String> searchByName(String name);
}