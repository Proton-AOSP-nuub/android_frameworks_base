package org.protonaosp.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SystemUIBinder;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SystemUIModule;

import org.protonaosp.systemui.columbus.ColumbusModule;
import org.protonaosp.systemui.keyguard.KeyguardSliceProviderProton;
import org.protonaosp.systemui.smartspace.KeyguardSmartspaceController;
import org.protonaosp.systemui.elmyra.ElmyraModule;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(modules = {
        ColumbusModule.class,
        DefaultComponentBinder.class,
        DependencyProvider.class,
        ElmyraModule.class,
        SystemUIModule.class,
        SystemUIProtonBinder.class,
        SystemUIProtonModule.class})
public interface SysUIComponentProton extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        SysUIComponentProton build();
    }

    /**
     * Member injection into the supplied argument.
     */
    void inject(KeyguardSliceProviderProton keyguardSliceProviderProton);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}
