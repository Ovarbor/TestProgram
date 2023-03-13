public class Ticket {

   private String origin;
   private String destination;
   private String destination_name;
   private String departure_date;
   private String departure_time;
   private String arrival_date;
   private String arrival_time;
   private String carrier;
   private Double stops;
   private Double price;

   public String getOrigin() {
      return origin;
   }

   public void setOrigin(String origin) {
      this.origin = origin;
   }

   public String getDestination() {
      return destination;
   }

   public void setDestination(String destination) {
      this.destination = destination;
   }

   public String getDestination_name() {
      return destination_name;
   }

   public void setDestination_name(String destination_name) {
      this.destination_name = destination_name;
   }

   public String getDeparture_date() {
      return departure_date;
   }

   public void setDeparture_date(String departure_date) {
      this.departure_date = departure_date;
   }

   public String getDeparture_time() {
      return departure_time;
   }

   public void setDeparture_time(String departure_time) {
      this.departure_time = departure_time;
   }

   public String getArrival_date() {
      return arrival_date;
   }

   public void setArrival_date(String arrival_date) {
      this.arrival_date = arrival_date;
   }

   public String getArrival_time() {
      return arrival_time;
   }

   public void setArrival_time(String arrival_time) {
      this.arrival_time = arrival_time;
   }

   public String getCarrier() {
      return carrier;
   }

   public void setCarrier(String carrier) {
      this.carrier = carrier;
   }

   public Double getStops() {
      return stops;
   }

   public void setStops(Double stops) {
      this.stops = stops;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }
}
