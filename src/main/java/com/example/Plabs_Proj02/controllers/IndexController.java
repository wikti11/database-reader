package com.example.Plabs_Proj02.controllers;

import com.example.Plabs_Proj02.entities.*;
import com.example.Plabs_Proj02.services.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    @GetMapping(value = "", produces = MediaType.TEXT_PLAIN_VALUE)
    String index() {
        return "Working paths: \n/driver \n/driver/add \n/driver/all \n/driver/delete/{integer} \n" +
                "/driver/edit \n/driver/paginated/{integer} \n/driver/lastname \n/driver/age/above30 \n" +
                "/driver/number/{integer} \n/driver/name/nationality/{string}/{string}\n\n" +
                "/result \n/result/add \n/result/all \n/result/delete/{integer} \n /result/edit \n" +
                "/result/paginated/{integer} \n/result/date \n/result/position/above10 \n" +
                "/result/position/{integer} \n/result/date/position/{string}/{integer} \n\n /team \n" +
                "/team/add \n/team/all \n /team/delete/{integer} \n/team/edit \n /team/paginated/{integer} \n" +
                "/team/name \n/team/yearfound/after1990 \n/team/enginesupplier/{string} \n" +
                "/team/localization/enginesupplier/{string}/{string} \n\n/teamprincipal \n/teamprincipal/add \n" +
                "/teamprincipal/all \n/teamprincipal/delete/{integer} \n/teamprincipal/edit \n" +
                "/teamprincipal/paginated/{integer} \n/teamprincipal/lastname \n/teamprincipal/age/above45 \n" +
                "/teamprincipal/firstname/{string} \n/teamprincipal/age/nationality/{integer}/{string} \n\n" +
                "/track \n/track/add \n/track/all \n/track/delete/{integer} \n/track/edit \n" +
                "/track/paginated/{integer} \n/track/name \n/track/length/above4000 \n" +
                "/track/yearbuilt/{integer} \n/track/country/corners/{string}/{integer}";
    }
}