package com.superops.bookyourticket.controller;

import com.superops.bookyourticket.model.ScreenSeatInfo;
import com.superops.bookyourticket.service.IScreenSeatService;
import com.superops.bookyourticket.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screen")
@CrossOrigin("*")
public class ScreenController extends BaseController{
}
