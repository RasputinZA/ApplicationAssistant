package za.ac.cput.service.financialAid.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.repository.financialAid.FundingRepository;
import za.ac.cput.service.financialAid.FundingService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FundingServiceImpl implements FundingService {

    @Autowired
    private FundingRepository repository;

    @Override
    public Set<Funding> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Funding> searchByName(String name) {
        Set<Funding> fundings = getAll();
        Set<Funding> fundingsWith = new HashSet<>();
        for (Funding funding : fundings) {
            if (funding.getFundingName().trim().toLowerCase().contains(name))
            {
                fundingsWith.add(funding);
            }
        }
        return fundingsWith;
    }

    @Override
    public Funding create(Funding funding) {
        return this.repository.save(funding);
    }

    @Override
    public Funding read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Funding update(Funding funding) {
        if (this.repository.existsById(funding.getFundingId())) {
            return this.repository.save(funding);
        }
        return null;
    }

        @Override
        public boolean delete (String s){
             this.repository.deleteById(s);

             if (this.repository.existsById(s)) {
                 return false;
             }
             else return true;
        }


}