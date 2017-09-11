package stepik.exersices;

import java.security.MessageDigest;
import java.util.Base64;

@FunctionalInterface
interface RequestHandler {
    Request handle(Request req);
    default RequestHandler setSuccessor(RequestHandler handler) {
        return (Request v) -> handler.handle(v);
    }
}

public class ChainOfResponsibilityDemo {
    final static RequestHandler wrapInTransactionTag =
            (req) -> new Request(String.format("<transaction>%s</transaction>", req.getData()));

    final static RequestHandler createDigest =
            (req) -> {
                String digest = "";
                try {
                    final MessageDigest md5 = MessageDigest.getInstance("MD5");
                    final byte[] digestBytes = md5.digest(req.getData().getBytes("UTF-8"));
                    digest = new String(Base64.getEncoder().encode(digestBytes));
                } catch (Exception ignored) { }
                return new Request(req.getData() + String.format("<digest>%s</digest>", digest));
            };

    final static RequestHandler wrapInRequestTag =
            (req) -> new Request(String.format("<request>%s</request>", req.getData()));

    public static void main(String[] args) {
        Request request = new Request("<type>payment</type><sum>100000</sum><order_id>e94dc619-6172-4ffe-aae8-63112c551570</order><desc>We'd like to buy an elephant</desc>");

        Request transactionRequest = wrapInTransactionTag.handle(request);
        System.out.println(transactionRequest.getData());

        System.out.println("=========================================================");

        Request digitalReques = createDigest.handle(transactionRequest);
        System.out.println(digitalReques.getData());

        System.out.println("=========================================================");

        Request requestTag = wrapInRequestTag.handle(digitalReques);
        System.out.println(requestTag.getData());

        System.out.println("=========================================================");

        RequestHandler commonHandler = wrapInRequestTag.setSuccessor(createDigest.setSuccessor(wrapInTransactionTag));
        Request commonReq = commonHandler.handle(request);
        System.out.println(commonReq.getData());
    }
}

class Request {
    private final String data;

    public Request(String requestData) {
        this.data = requestData;
    }

    public String getData() {
        return data;
    }
}