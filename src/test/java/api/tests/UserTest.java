package api.tests;

import api.endpoints.UserEndpoints;
import api.utilities.Keys;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class UserTest {

    @Test
    public void validateFanCodeUsersTodosCompletion() {
        // Step 1: Get all users
        Response userResponse = UserEndpoints.getAllUsers();
        Assert.assertEquals(userResponse.statusCode(), 200, "Failed to fetch users");

        // Step 2: Identify users from the FanCode city (latitude between -40 and 5, longitude between 5 and 100)
        List<Integer> fancodeUserIds = from(userResponse.asString()).getList("findAll { user -> " +
                "user.address.geo." + Keys.LATITUDE.getKey() + ".toFloat() > -40 && " +
                "user.address.geo." + Keys.LATITUDE.getKey() + ".toFloat() < 5 && " +
                "user.address.geo." + Keys.LONGITUDE.getKey() + ".toFloat() > 5 && " +
                "user.address.geo." + Keys.LONGITUDE.getKey() + ".toFloat() < 100 }.id");

        // Step 3: For each FanCode user, check their todo tasks
        for (int userId : fancodeUserIds) {
            Response todosResponse = UserEndpoints.getTodosForUser(userId);
            Assert.assertEquals(todosResponse.statusCode(), 200, "Failed to fetch todos for userId: " + userId);

            // Step 4: Calculate completed todos
            List<Boolean> todosCompletionStatus = from(todosResponse.asString()).getList("completed");
            long completedCount = todosCompletionStatus.stream().filter(completed -> completed).count();
            int totalTodos = todosCompletionStatus.size();

            // Step 5: Assert that more than 50% of todos are completed
            Assert.assertTrue(completedCount > totalTodos / 2.0, "User " + userId + " has less than 50% completed todos");
        }
    }
}
