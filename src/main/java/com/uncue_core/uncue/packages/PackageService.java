package com.uncue_core.uncue.packages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    @Autowired
    PackageRepository repository;
    public List<Package> getPackages() {
      return  repository.findAllByOrderByPackageIdDesc();
    }

    public Package getPackage(int packageId) {
     return   repository.findById(packageId).get();
    }

    public Package insertPackage(Package packages) {
     return   repository.save(packages);
    }
}
