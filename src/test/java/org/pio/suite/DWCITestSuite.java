package org.pio.suite;

import org.junit.ClassRule;
import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.runner.RunWith;
import org.pio.test.TestContext;

/**
 * User: pwyrwins
 * Date: 2/16/13
 * Time: 5:27 PM
 */
@RunWith(ClasspathSuite.class)
public class DWCITestSuite {

    @ClassRule
    public static TestContext testContext = new TestContext(true);

}
