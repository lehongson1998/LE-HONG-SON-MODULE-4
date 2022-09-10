package com.case_study.controlleer.restfull;

import com.case_study.model.contract.Contract;
import com.case_study.model.contract.ContractDetail;
import com.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/contractRest")
@RestController
public class ContractRestController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<ContractDetail>> showList(@PathVariable Long id){
        List<ContractDetail> contractDetails = iContractService.listContractDetail(id);

        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetails,HttpStatus.OK);
    }
}
