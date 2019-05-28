package no.uio.ifi.handlers

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import no.uio.ifi.bio.getAlignment
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

class SmithWatermanHandler : RequestHandler<Map<String, Any?>, Response> {

    var logger: Logger = getLogger(javaClass)

    override fun handleRequest(input: Map<String, Any?>, context: Context?): Response {
        val queryStringParameters: Map<*, *> = input["queryStringParameters"] as Map<*, *>
        logger.info("queryStringParameters: {}", queryStringParameters)
        val uniProteinId1 = queryStringParameters["uniProteinId1"]
        val uniProteinId2 = queryStringParameters["uniProteinId2"]
        if (uniProteinId1 == null || uniProteinId2 == null) {
            return Response(400, emptyMap(), "Bad request")
        }
        val alignment = getAlignment(uniProteinId1.toString(), uniProteinId2.toString())
        return Response(body = alignment)
    }

}

data class Response(
    val statusCode: Int = 200,
    val headers: Map<String, String> = mapOf(Pair("Content-Type", "text/plain")),
    val body: String
)
