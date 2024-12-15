package com.example.excercise22relation1w8.Service;

import com.example.excercise22relation1w8.AddressDTO.AddressDTO;
import com.example.excercise22relation1w8.Api.ApiException;
import com.example.excercise22relation1w8.DTO.AddressOutDTO;
import com.example.excercise22relation1w8.Model.Address;
import com.example.excercise22relation1w8.Model.Teacher;
import com.example.excercise22relation1w8.Repository.AddressRepository;
import com.example.excercise22relation1w8.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    /*
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
     */

    public List<AddressOutDTO> getAllAddress() {
        List<Address> addressList = addressRepository.findAll();
        List<AddressOutDTO> addressDTOs = new ArrayList<>();
        for (Address address : addressList) {
            AddressOutDTO addressDTO = new AddressOutDTO(address.getArea(),address.getStreet(),address.getBuildingNumber());
            addressDTOs.add(addressDTO);
        }
        return addressDTOs;

    }
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("Address not found");
        }
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setArea(addressDTO.getArea());
        addressRepository.save(address);
    }

}
