import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static java.time.LocalTime.ofSecondOfDay;

public class Report {

    private final FileReader fileReader = new FileReader();
    private final Gson gson = new Gson();
    private final List<Integer> secondsFlightTime = new ArrayList<>();

    public void readReport(String path) {
        JsonElement jsonElement = JsonParser.parseString(fileReader.readContent(path));
        Map map = gson.fromJson(jsonElement, Map.class);
        String json = new Gson().toJson(map.get("tickets"));
        Type listTicketType = new TypeToken<ArrayList<Ticket>>() {}.getType();
        ArrayList<Ticket> ticketArrayList = new Gson().fromJson(json, listTicketType);
        getFlightTime(ticketArrayList);
    }

    public LocalTime getAverageTime() {
        return ofSecondOfDay(secondsFlightTime.stream().mapToInt(Integer::intValue).sum() / secondsFlightTime.size());
    }

    public LocalTime getPercentile() {
        return ofSecondOfDay(secondsFlightTime.get(((secondsFlightTime.size() + 1) * 90 / 100) - 1));
    }

    private void getFlightTime(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList) {
            String[] values = ticket.getDeparture_time().split(":");
            LocalTime localTime = LocalTime.parse(ticket.getArrival_time()).minusHours(Long.parseLong(values[0].trim()))
                    .minusMinutes(Long.parseLong(values[1].trim())).plusHours(8);
            Integer convertedLocalTime = localTime.toSecondOfDay();
            secondsFlightTime.add(convertedLocalTime);
        }
        Collections.sort(secondsFlightTime);
    }
}
