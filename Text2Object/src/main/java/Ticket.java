import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;


import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.Math.sqrt;
//toplam totalPrice ı veren bi metot, statusu CONFIRMED olanların price'ı, status u CANCELLED olanların price'ıv


@Getter
@Setter
public class Ticket {
    public int id;
    public String bookingTime;
    public Date checkIn;
    public Date checkOut;
    public String currency;
    public BigDecimal totalPrice;
    public String status;
    public  static   void main(String[] args) throws JsonProcessingException {

        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");




        Map<String,String> korsanharitasi = new HashMap<String,String>(); // HASHMAP
        korsanharitasi.put("75339.31","EUR");
        korsanharitasi.put("367952.25","TRY");
        String json = new ObjectMapper().writeValueAsString(korsanharitasi); // Hashmap to jSon conversion
        //System.out.println(json);
        //System.out.println(korsanharitasi);

        String txtFile = "\\Users\\DD\\IdeaProjects\\Text2Object\\src\\main\\java\\parsing.txt";
        BufferedReader br = null;
        String line = "";
        String txtSplit = ",";
        try {
            List<Ticket> tickets = new ArrayList<Ticket>();
            br = new BufferedReader(new FileReader(txtFile));
            while ((line = br.readLine()) != null) {
                if (line.startsWith("id") || line.equals("")) {
                    continue;
                }
                Ticket t = new Ticket(); // ticket object
                String[] parsing = line.split(txtSplit);
                t.setId(Integer.parseInt(parsing[0]));
                t.setCheckIn(formatter2.parse(parsing[1]));
                t.setBookingTime(parsing[2]);
                t.setCheckOut(formatter2.parse(parsing[3]));
                t.setCurrency(parsing[4]);
                t.setTotalPrice(new BigDecimal(parsing[5]));
                t.setStatus(parsing[6]);
                tickets.add(t);
                System.out.println(line.toString());
                System.out.println(totalPrice(tickets));

            }
            //System.out.println(max_price(tickets));
            //System.out.println(min_price(tickets));
            //System.out.println(euroSum(tickets)); // 75339.31
            //System.out.println(trSum(tickets));  // 367952.25


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
            e.printStackTrace();
        } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }


        }



    public  static BigDecimal totalPrice(List<Ticket> tickets) {
        BigDecimal result = new BigDecimal("0.0");
        for(int i=0; i<tickets.size(); i++){
            result = result.add(tickets.get(i).getTotalPrice());
        }
        return result;
        

        }


            public static BigDecimal max_price(List<Ticket> tickets) {
            //BigDecimal max = new BigDecimal(String.valueOf(tickets.get(0).getTotalPrice()));
            BigDecimal maxx = (tickets.get(0).getTotalPrice());

            for (int i = 0; i < tickets.size(); i++) {

                BigDecimal element = (tickets.get(i).getTotalPrice());
                if (element.compareTo(maxx) > 0 ) {
                           maxx = element;
                }


            }

            return maxx;

        }

       public static BigDecimal min_price(List<Ticket> tickets) {
        BigDecimal min =  (tickets.get(0).getTotalPrice());

        for(int i=0 ; i<tickets.size(); i++) {
            BigDecimal element = (tickets.get(i).getTotalPrice());
            if(element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
        }


        public static BigDecimal euroSum(List<Ticket> tickets) {
        BigDecimal sum = new BigDecimal("0.0");

        for(int i=0; i< tickets.size(); i++) {
            if(tickets.get(i).getCurrency().equals("EUR")){
              sum = sum.add(tickets.get(i).getTotalPrice());
            }
        }


        return sum;
        }

    public static BigDecimal trSum(List<Ticket> tickets) {
        BigDecimal sum = new BigDecimal("0.0");

        for(int i=0; i< tickets.size(); i++) {
            if(tickets.get(i).getCurrency().equals("TRY")){
                sum = sum.add(tickets.get(i).getTotalPrice());
            }
        }


        return sum;
    }









}





