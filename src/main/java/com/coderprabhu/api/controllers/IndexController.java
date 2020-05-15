package com.coderprabhu.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.coderprabhu.api.counter.Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 */
@RestController
public class IndexController {

  @Autowired Counter counter;
    
  static class Self {
    public String href;
  }

  static class Links {
    public Self self;
  }

  static class PlayerState {
    public Integer x;
    public Integer y;
    public String direction;
    public Boolean wasHit;
    public Integer score;
	@Override
	public String toString() {
		return "PlayerState [x=" + x + ", y=" + y + ", direction=" + direction + ", wasHit=" + wasHit + ", score="
				+ score + "]";
	}
  }

  static class Arena {
    public List<Integer> dims;
    public Map<String, PlayerState> state;
    @Override
	public String toString() {
		return "Arena [dims=" + dims + ", state=" + state + "]";
	}
  }

  static class ArenaUpdate {
    public Links _links;
    public Arena arena;
    @Override
	public String toString() {
		return "ArenaUpdate [_links=" + _links + ", arena=" + arena + "]";
	}
  }

    @GetMapping(value="/")
    @CrossOrigin(origins = "*")
    public String home() {
        System.out.println("get");
        return "Let the battle begin!";
    }

    @PostMapping(value="/")
    @CrossOrigin(origins = "*")
    public String post(@RequestBody ArenaUpdate arenaUpdate) {
        System.out.println("Incoming: " + arenaUpdate);
        String[] commands = new String[]{"F", "R", "L", "T"};
        int i = new Random().nextInt(4);
        return commands[i];
    }

    @GetMapping(value="/hello")
    @CrossOrigin(origins = "*")
    public String hello() {
        counter.increament();
        return "CoderPraBhu says: Hello!";
    }

    @GetMapping(value="/count")
    @CrossOrigin(origins = "*")
    public int count() {
        return counter.getCount();
    }
}