
package biz.netcentric.cq.tools.actool.configuration;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals ;
import biz.netcentric.cq.tools.actool.helper.AceBean;


public class CqActionsMappingTest {
	AceBean aceBean1;
	AceBean aceBean2;
	

	@Before
	public void setup() {
		// ACEs from groups contained in config

		aceBean1 = new AceBean();
		aceBean1.setPrincipal("group-A");
		aceBean1.setActions(null);
		aceBean1.setActionsString("");
		aceBean1.setAllow(false);
		aceBean1.setJcrPath("/content");
		aceBean1.setPrivilegesString("jcr:read,crx:replicate");
		aceBean1.setRepGlob("");

		aceBean2 = new AceBean();
		aceBean2.setPrincipal("group-A");
		aceBean2.setActions(new String[]{"read","replicate"});
		aceBean2.setAllow(false);
		aceBean2.setJcrPath("/content");
		aceBean2.setPrivilegesString("");
		aceBean2.setRepGlob("");
	}
	@Test
	public void getConvertedPrivilegeBeanTest(){
		aceBean2 = CqActionsMapping.getConvertedPrivilegeBean(aceBean2);

		assertArrayEquals(aceBean1.getActions(), aceBean2.getActions());
		assertEquals(aceBean1.getPrivilegesString(), aceBean2.getPrivilegesString());
	}
}