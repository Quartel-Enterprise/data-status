package software.quare.data_status

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

internal class DataStatusUtilsTest {

    @Test
    fun `when generateLoading is called with 0, it returns an empty list`() {
        val result = DataStatusUtils.generateLoading(0)
        assertThat(result).isEmpty()
    }

    @Test
    fun `when generateLoading is called with a positive number, it returns a list of Loading states`() {
        val amount = 5
        val result = DataStatusUtils.generateLoading(amount)
        assertThat(result).hasSize(amount)
    }

    @Test
    fun `when generateLoading is called with a negative number, it returns an empty list`() {
        val result = DataStatusUtils.generateLoading(-3)
        assertThat(result).isEmpty()
    }
}
