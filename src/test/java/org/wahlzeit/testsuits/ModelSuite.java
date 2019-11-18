package org.wahlzeit.testsuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //AbstractAdapterTest.class,
		DatastoreAdapterTest.class,

        AccessRightsTest.class,
        CoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        LandscapePhotoTest.class,
        LandscapePhotoManagerTest.class,
        LandscapePhotoFactoryTest.class
})

public class ModelSuite {
}