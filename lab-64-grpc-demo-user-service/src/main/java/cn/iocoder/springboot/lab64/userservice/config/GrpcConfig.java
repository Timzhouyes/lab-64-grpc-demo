package cn.iocoder.springboot.lab64.userservice.config;

import cn.iocoder.springboot.lab64.userservice.rpc.UserServiceGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final Integer GRPC_PORT = 8888;

    @Bean
    public Server GrpcServer(final UserServiceGrpcImpl userServiceGrpc) throws IOException {
        Server server = ServerBuilder.forPort(GRPC_PORT)
            .addService(userServiceGrpc)
            .build();
        server.start();
        logger.info("[grpcServer][启动完成，端口为({})]", server.getPort());
        return server;
    }
}
