package de.thomasletsch

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class LogoutTest {

    @Test
    @Ignore("Only working in BiSecure Environment")
    fun testLogout() {
        val discovery = Discovery()
        val future = discovery.startServer()
        discovery.sendDiscoveryRequest()
        val discoveryData = future.join()

        val client = Client(discoveryData.sourceAddress, "000000000000", discoveryData.getGatewayId())
        val clientAPI = ClientAPI(client)
        clientAPI.login("thomas", "aaabbbccc")
        clientAPI.logout()
        assertThat(client.token).isEqualTo(Client.defaultToken)
    }
}
