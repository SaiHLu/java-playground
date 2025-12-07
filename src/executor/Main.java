package executor;

public class Main {
    static void main() {
        /**
         * Simulate sending email with async op
         */
//        MailService mailService = new MailService();
//        mailService.sendAsync();
//        System.out.println("Async operation done.");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        CompletableFutureExample.show();
//        ExecutorExample.show();
    }
}
