package za.ac.cput.controller.financialAid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.factory.financialAid.FundingFactory;
import za.ac.cput.service.financialAid.impl.FundingServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/funding")
public class FundingController {

    @Autowired
    private FundingServiceImpl fundingService;

    @PostMapping("/create")
    public Funding create(@RequestBody Funding funding)
    {
        funding = FundingFactory.createFunding(funding.getFundingName(), funding.getFundingRequirements());
        return fundingService.create(funding);
    }

    @GetMapping("/all")
    public Set<Funding> getAll() {return fundingService.getAll();}

    @GetMapping("/search/{name}")
    public Set<String> searchBy(@PathVariable String name) {return fundingService.searchByName(name);}

    @GetMapping("/read/{id}")
    public Funding read(@PathVariable String id)
    {
        return fundingService.read(id);
    }

    @PostMapping("/update")
    public Funding update(@RequestBody Funding funding)
    {
        return fundingService.update(funding);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id)
    {
        return fundingService.delete(id);
    }
}
