package com.uncue_core.uncue.Bill;


import com.uncue_core.uncue.LobArray.IntegerArray;
import com.uncue_core.uncue.LobArray.Map;
import com.uncue_core.uncue.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${BaseUrl}")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("${insertOrUpdateBIll}")
    public Bill insertBIll(@RequestBody Bill bill) {
        return billService.insertBIll(bill);

    }

    @GetMapping("${reteriveBIlls}")
    public List<Bill> getBIlls(@PathVariable("saloonId") int saloonId) {

        return   billService.getBIlls(saloonId);

    }

    @GetMapping("${reteriveBill}")
    public Bill getBIll(@PathVariable("billid") int billid) {
        return   billService.getBIll(billid);
    }
}
