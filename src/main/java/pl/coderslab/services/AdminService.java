package pl.coderslab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Admin;
import pl.coderslab.repositories.AdminRepository;

@Component
public class AdminService {
    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAll() {
        List<Admin> admins = (List<Admin>) this.adminRepository.findAll();
        return admins;

    }

    public Admin getAdmin(int id) {
        Optional<Admin> optional = this.adminRepository.findById(id);
        Admin admin = optional.get();
        return admin;

    }

    public void updateAdmin(Admin admin, int id) {
        for (Admin ad : getAll()) {
            if (ad.getAdminId() == id) {
                this.adminRepository.save(admin);
            }
        }
    }

    public void delete(int id) {
        this.adminRepository.deleteById(id);
    }

    public void addAdmin(Admin admin) {
        this.adminRepository.save(admin);
    }

    public boolean validateAdminCredentials(String email, String password) {
        Admin admin = adminRepository.findByadminEmail(email);
        if (admin != null && admin.getAdminPassword().equals(password)) {
            return true;
        }
        return false;
    }
}


