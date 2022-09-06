package com.phone_management.controller.restfull;

import com.phone_management.model.SmartPhone;
import com.phone_management.repository.ISmartPhoneRepository;
import com.phone_management.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/smartphones")
public class SmartPhoneRestController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping("/add")
    public ResponseEntity<Void> createSmartphone(@RequestBody SmartPhone smartPhone) {
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<Page<SmartPhone>> getAllSmartPhonePage(Pageable pageable) {
        Page<SmartPhone> smartphones = this.smartPhoneService.findAll(pageable);
        if (!smartphones.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(smartphones,HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Optional<SmartPhone>> getPhone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Iterable<SmartPhone>> updateSmartphone(@RequestBody SmartPhone smartphone,Pageable pageable) {
        smartPhoneService.save(smartphone);
        return new ResponseEntity<>(smartPhoneService.findAll(pageable), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
