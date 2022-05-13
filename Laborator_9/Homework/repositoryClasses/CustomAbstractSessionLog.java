package repositoryClasses;

import org.eclipse.persistence.logging.AbstractSessionLog;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.logging.SessionLogEntry;

public class CustomAbstractSessionLog extends AbstractSessionLog implements SessionLog {

    @Override
    public void log(SessionLogEntry sessionLogEntry) {
        System.out.println("CUSTOM: " + sessionLogEntry.getMessage()); // untranslated/undecoded message_id
    }
}
