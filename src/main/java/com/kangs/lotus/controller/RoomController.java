package com.kangs.lotus.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/room/")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {
}
