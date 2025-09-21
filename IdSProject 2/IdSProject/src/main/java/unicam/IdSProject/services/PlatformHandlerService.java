package unicam.IdSProject.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicam.IdSProject.models.Mailbox;
import unicam.IdSProject.models.PlatformHandler;
import unicam.IdSProject.repositories.ReceiptRepository;

@Service
@AllArgsConstructor
public class PlatformHandlerService {

    private final ReceiptRepository receiptRepository;

    private final PlatformHandler platformHandler;

    private Mailbox mailbox;

    public ResponseEntity<Object> getReceipts() {
        return new ResponseEntity<>(receiptRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> openMailbox() {
        return new ResponseEntity<>(mailbox.getMessages(), HttpStatus.OK);
    }

}
