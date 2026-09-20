package community.capacitor.android.security.provider

import android.content.Context
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.security.ProviderInstaller

public class CapacitorSecurityProvider(private val context: Context) {
    public fun installIfNeeded(): String = try {
        ProviderInstaller.installIfNeeded(context)
        "Success"
    } catch (e: GooglePlayServicesRepairableException) {
        // Indicates that Google Play services is out of date, disabled, etc.

        // Prompt the user to install/update/enable Google Play services.
        GoogleApiAvailability.getInstance().showErrorNotification(context, e.connectionStatusCode)

        // Notify the WorkManager that a soft error occurred.
        "GooglePlayServicesRepairableException"
    } catch (e: GooglePlayServicesNotAvailableException) {
        // Indicates a non-recoverable error; the ProviderInstaller can't
        // install an up-to-date Provider.

        // Notify the WorkManager that a hard error occurred.
        "GooglePlayServicesNotAvailableException"
    }
}
