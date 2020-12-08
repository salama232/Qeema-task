package com.qeema.task.Service;

import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebSocketSession_Service {
private Map<String, Principal> sessionMap = new ConcurrentHashMap<>();
public void setUserSession(String email, Principal principal) {
    sessionMap.put(email, principal);
}

public void removeSession(String email) {
    sessionMap.remove(email);
}

public boolean sessionExists(String email) {
    return sessionMap.containsKey(email);
}
}
