package com.project.newsletter.service;

import com.project.newsletter.model.Admin;
import com.project.newsletter.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void registerAdmin(Admin admin) {
        log.info("registerAdmin >> {}", admin.getFullName());
        adminRepository.save(admin);
    }

    public Optional<Admin> getAdmin(String emailId) {
        return adminRepository.findByEmailId(emailId);
    }

}
