package com.example.hw23.Service;

import com.example.hw23.ApiException.ApiException;
import com.example.hw23.DTO.AddressDTO;
import com.example.hw23.Model.Address;
import com.example.hw23.Model.Teacher;
import com.example.hw23.Repository.AddressRepository;
import com.example.hw23.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addAddress(AddressDTO dto) {
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null, dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Integer id, Address address) {
        Address oldAddress = addressRepository.findAddressById(id);
        if (oldAddress == null) {
            throw new ApiException("Address not found");
        }
        oldAddress.setArea(address.getArea());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setBuildingNumber(oldAddress.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("Address not found");
        }
        addressRepository.deleteById(id);
    }

}


