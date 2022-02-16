package cn.iocoder.springboot.lab64.userservice.rpc;

import cn.iocoder.springboot.lab64.userservice.api.UserCreateRequest;
import cn.iocoder.springboot.lab64.userservice.api.UserCreateResponse;
import cn.iocoder.springboot.lab64.userservice.api.UserGetRequest;
import cn.iocoder.springboot.lab64.userservice.api.UserGetResponse;
import cn.iocoder.springboot.lab64.userservice.api.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void get(UserGetRequest request, StreamObserver<UserGetResponse> responseObserver) {
        //创建响应对象
        UserGetResponse.Builder builder = UserGetResponse.newBuilder();
        builder.setId(request.getId())
            .setName("没有昵称：" + request.getId())
            .setGender(request.getId() % 2 + 1);
        //返回响应
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void create(UserCreateRequest request,
                       StreamObserver<UserCreateResponse> responseObserver) {
        UserCreateResponse.Builder builder = UserCreateResponse.newBuilder();
        builder.setId((int) (System.currentTimeMillis() / 1000));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
