package session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionFactory {
    private final static String SESSION_KEY = "MY_SID";

    private static Map<String, MySession> sessions = new HashMap<>();

    public static MySession getSession(HttpServletRequest req, HttpServletResponse resp) {
        String sid = null;
        MySession session = null;

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SESSION_KEY)) {
                    sid = cookie.getValue();
                    break;
                }
            }
        }

        if (!checkSessionId(sid)) {
            sid = generateSessionId();
            session = createNewSession(sid);
            resp.addCookie(new Cookie(SESSION_KEY, sid));
        } else {
            session = sessions.get(sid);

            if (session == null) {
                session = createNewSession(sid);
            }
        }

        return session;
    }

    private static boolean checkSessionId(String sid) {
        return !(sid == null || sid.isEmpty());
    }

    private static String generateSessionId() {
        return String.valueOf(UUID.randomUUID());
    }

    private static MySession createNewSession(String sid) {
        MySession session = new MemorySession(sid);
        sessions.put(sid, session);
        return session;
    }
}
