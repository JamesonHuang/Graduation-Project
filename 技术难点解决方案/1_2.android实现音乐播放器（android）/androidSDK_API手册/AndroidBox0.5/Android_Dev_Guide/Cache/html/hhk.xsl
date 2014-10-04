<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">	
	<xsl:output method="xml" version="1.0" omit-xml-declaration="yes" />
	<xsl:template match="/">
		<HTML>
			<BODY>
				<UL>
					<xsl:for-each select="//OBJECT" >
						<xsl:sort select="PARAM[@name='Name']/@value" data-type="text" />
						<LI> 
							<OBJECT type="text/sitemap">
								<xsl:for-each select="PARAM" >
									<xsl:if test="@name != 'ImageNumber'">
										<xsl:copy-of select="." />
									</xsl:if>
								</xsl:for-each>
							</OBJECT>
						</LI>
					</xsl:for-each>
				</UL>
			</BODY>
		</HTML>
	</xsl:template>	
</xsl:stylesheet>
