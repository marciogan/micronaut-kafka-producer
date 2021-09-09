package kafka.producer.integration.products.commons.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class IuppLogger {

    companion object Factory {
        val logger: Logger = LoggerFactory.getLogger(IuppLogger::javaClass.name)
    }
}
