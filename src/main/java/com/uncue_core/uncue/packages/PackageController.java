package com.uncue_core.uncue.packages;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class PackageController {


    @Autowired
    PackageService service;



    @GetMapping("${reterivePackages}")
    public List<Package> getPackages() {
        return service.getPackages();
    }

    @GetMapping("${reterivepackage}")
    public Package getPackage(@PathVariable("packageId") int packageId) {
        return   service.getPackage(packageId);

    }

    @PostMapping("${insertOrUpdatePackage}")
    public Package addPackage(@RequestBody Package packaage) {

        return service.insertPackage(packaage);

    }
}
