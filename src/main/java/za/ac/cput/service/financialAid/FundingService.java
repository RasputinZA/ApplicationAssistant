package za.ac.cput.service.financialAid;

import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.service.IService;

import java.util.*;

public interface FundingService extends IService<Funding, String> {

    Set<Funding> getAll();

    Set<String> searchByName(String name);
}