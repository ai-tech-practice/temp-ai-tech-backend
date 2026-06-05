package commentory.risk.medium;

import java.util.List;

public class TaskLimitServiceProbe {
    public List<String> listRecentTasks(List<String> tasks, int requestedLimit) {
        int limit = requestedLimit <= 0 ? 20 : Math.min(requestedLimit, 50);
        return tasks.stream()
            .limit(limit)
            .toList();
    }
}
