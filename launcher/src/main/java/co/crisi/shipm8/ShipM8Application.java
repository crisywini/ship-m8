package co.crisi.shipm8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "co.crisi.shipm8")
public class ShipM8Application {

    public static void main(String[] args) {
        SpringApplication.run(ShipM8Application.class, args);
    }

}
