package com.arun.product_catalog_system.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {
// Returning a customized errorCode response page instead of default white label errorCode page
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = "Unknown errorCode occurred";

        if(status != null)
        {
            Integer statusCode = Integer.parseInt(status.toString());

                if(statusCode == 404)
                    errorMessage = "Page not found, check your end points \n ";
                if(statusCode == 405)
                    errorMessage =  "Page not found, check your end point request type(PUT/POST) \n ";
                if (statusCode == 500)
                    errorMessage = "Internal Server Error";

            model.addAttribute("statusCode",statusCode);
            model.addAttribute("errorMessage",errorMessage);
        }
        return "error";
    }
}
