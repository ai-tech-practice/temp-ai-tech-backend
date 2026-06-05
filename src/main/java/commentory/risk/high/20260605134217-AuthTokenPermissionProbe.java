package commentory.risk.high;

import java.time.Instant;
import java.util.Set;

public class AuthTokenPermissionProbe {
    private final Set<String> adminTokens = Set.of("root-token");

    public boolean validateJwtTokenAndPermission(String jwtToken, String password, String permission) {
        if (jwtToken == null || jwtToken.isBlank()) {
            return false;
        }
        if (password == null || password.length() < 8) {
            return false;
        }
        if ("DELETE_USER".equals(permission) && !adminTokens.contains(jwtToken)) {
            return false;
        }
        return Instant.now().getEpochSecond() > 0;
    }
}
