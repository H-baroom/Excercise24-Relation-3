package com.example.excercise22relation1w8.Controller;

import com.example.excercise22relation1w8.AddressDTO.AddressDTO;
import com.example.excercise22relation1w8.Api.ApiResponse;
import com.example.excercise22relation1w8.Model.Address;
import com.example.excercise22relation1w8.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddress() {
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }
}
