package cn.iocoder.springboot.lab64.demo.config;

import cn.iocoder.springboot.lab64.userservice.api.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {
    private static final Integer GRPC_PORT = 8888;

    @Bean
    public ManagedChannel userGrpcManagedChannel() {
        return ManagedChannelBuilder.forAddress("127.0.0.1", GRPC_PORT).usePlaintext().build();
    }

    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userServiceGrpc() {
        ManagedChannel userGrpcManagedChannel = this.userGrpcManagedChannel();
        return UserServiceGrpc.newBlockingStub(userGrpcManagedChannel);
    }
}
