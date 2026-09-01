package com.learn.desgin.lld.parkinglot.config;

import com.learn.desgin.lld.parkinglot.model.gate.EntryGate;
import com.learn.desgin.lld.parkinglot.model.gate.ExitGate;
import com.learn.desgin.lld.parkinglot.model.payment.Payment;
import com.learn.desgin.lld.parkinglot.model.ticket.EntryTicket;
import com.learn.desgin.lld.parkinglot.model.ticket.ExitTicket;
import com.learn.desgin.lld.parkinglot.model.vehicle.Vehicle;
import com.learn.desgin.lld.parkinglot.model.vehicle.VehicleType;
import com.learn.desgin.lld.parkinglot.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class StartApplication {
    private final ObjectMapper mapper;
    private final ParkingLotService service;

    @Bean
    public CommandLineRunner start() {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("""
                        Details ::
                        1 Entry
                        2 Exit
                        3 Close
                        """);

                int entryOrExit = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (entryOrExit == 1) {
                    System.out.println("Enter Entry Gate Number");
                    EntryGate entryGate = new EntryGate(scanner.nextLong());
                    scanner.nextLine();
                    System.out.println("Enter Vehicle Details ::");
                    System.out.println("Enter the Vehicle Number");

                    String vehicleNumber = scanner.nextLine();
                    System.out.println("Enter the Vehicle Type");
                    System.out.println(Arrays.toString(VehicleType.values()));

                    int type = scanner.nextInt();
                    scanner.nextLine();

                    VehicleType vehicleType = VehicleType.values()[type - 1];

                    Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType);
                    EntryTicket ticket = service.park(vehicle, entryGate);
                    Object ticketJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ticket);
                    System.out.println(ticketJson);
                    System.out.println(ticket.getId());

                } else if (entryOrExit == 2) {
                    System.out.println("Exit the vehicle");
                    System.out.println("Exit Vehicle Details::\nEntry ticket id : ");
                    String id = scanner.nextLine();
                    System.out.println("Payment Type");
                    System.out.println(Arrays.toString(Payment.values()));

                    int paymentType = scanner.nextInt();
                    scanner.nextLine();

                    Payment payment = Payment.values()[paymentType - 1];
                    System.out.println("Enter Exit Gate Number");
                    ExitGate exitGate = new ExitGate(scanner.nextLong());
                    scanner.nextLine();

                    ExitTicket ticket = service.unPark(UUID.fromString(id),payment,exitGate);
                    Object ticketJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ticket);
                    System.out.println(ticketJson);

                } else if (entryOrExit == 3) {
                    System.exit(0);
                }

            } while (true);
        };
    }
}
